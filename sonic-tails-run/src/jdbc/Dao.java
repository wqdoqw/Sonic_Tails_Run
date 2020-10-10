package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import dto.LeaderBoard;
import static resource.Resource.score;
import static resource.Resource.leaderBoardList;

/**
 * 
 * @author Sang Ik Park
 *
 *
 */
public class Dao {
	private static Connection conn;
	private static Statement stmt;
	private static ResultSet rs;
	private static PreparedStatement pstmt;
	private static final String SELECTBYSCORE = "SELECT * FROM leaderboard ORDER BY score DESC";
	private static final String SELECTBYNAME = "SELECT * FROM leaderboard where name=?";
	private static final String INSERT = "INSERT INTO leaderboard (name,score,time) VALUES(?,?,?)";

	private Dao() {
	}

	/**
	 * <p>
	 * 해쉬맵에다가 스코어기준 오름차순대로 튜플을 저장한다.
	 * </p>
	 */
	public static void loadData() {
		conn = ConfigureDatabase.connect();
		// 원래 있던 데이터를 지운다.
		leaderBoardList.clear();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SELECTBYSCORE);
			while (rs.next()) {
				String name = rs.getString(1);
				Integer score = rs.getInt(2);
				// timestamp의 -를 /로 바꾼다
				String time = rs.getString(3).replaceAll("-", "/").substring(0, 10);
				leaderBoardList.add(new LeaderBoard(name, score, time));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * <p>
	 * DB에 데이터를 저장한다
	 * </p>
	 * 
	 * @param name 유저의 이름
	 * @return boolean 데이터베이스에 추가가 되면 참 아니면 거짓을 반환한다.
	 */
	public static boolean insertData(String name) {
		Timestamp time = new Timestamp(System.currentTimeMillis());
		conn = ConfigureDatabase.connect();
		// 중복체크
		if (duplicationCheck(name)) {
			return false;
		}
		try {
			pstmt = conn.prepareStatement(INSERT);
			pstmt.setString(1, name);
			pstmt.setString(2, "" + score.getScore());
			pstmt.setTimestamp(3, time);
			pstmt.executeUpdate();
			pstmt.close();
			System.out.println("insertion complete");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConfigureDatabase.close(rs, pstmt, conn);
		}
		return true;
	}

	/**
	 * <p>
	 * 기본키인 이름을 기준으로 중복 검사를 한다. 중복된 데이터가 있으면 참을 반환하고 없으면 거짓을 반환한다.
	 * </p>
	 * 
	 * @param name 기본키인 이름을 기준으로 중복을 체크한다.
	 * @return boolean 중복된 데이터면 참을 반환 아니면 거짓을 반환한다.
	 */
	public static boolean duplicationCheck(String name) {
		conn = ConfigureDatabase.connect();
		try {
			pstmt = conn.prepareStatement(SELECTBYNAME);
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();
			if (!rs.next()) {
//				System.out.println("no data");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
}

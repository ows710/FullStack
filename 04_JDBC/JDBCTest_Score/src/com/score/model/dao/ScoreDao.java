package com.score.model.dao;

import java.sql.Connection;
import java.util.List;

import com.score.model.dto.Score;

public interface ScoreDao {
	
	String getAllSqL = " SELECT * FROM SCORE ";
	String getOneSqL = " SELECT * FROM SCORE WHERE NAME=? ";
	String insertSqL = " INSERT INTO SCORE VALUES(?,?,?,?,?,?,?) ";
	String updateSqL = " UPDATE SCORE SET KOR=?,ENG=?,MATH=?,SUM =?,AVG=?,GRADE=? WHERE NAME=? ";
	String deleteSqL = " DELETE FROM SCORE WHERE NAME=? ";
	
	public List<Score> getAll(Connection con);
	public Score getOne(Connection con, String name);
	public int insert(Connection con, Score s);
	public int update(Connection con, Score s);
	public int delete(Connection con, String name);
}

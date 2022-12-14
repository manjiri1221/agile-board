package com.agile.board.entity;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
/**
 * Entity for Board
 * @author manjirilakhote
 *
 */
@Document("board")
public class Board extends CommonEntity{

	public Board(String name, ObjectId createdBy) {
		super();
		this.setName(name);
		this.setCreatedBy(createdBy);
	}
	Board(){}

}

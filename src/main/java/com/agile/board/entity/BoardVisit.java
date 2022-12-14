package com.agile.board.entity;

import java.util.Date;

import org.bson.types.ObjectId;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
/**
 * Entity for details of user's visit on board
 * @author manjirilakhote
 *
 */
@Data
public class BoardVisit {

	private ObjectId boardId;
	private Date lastVisitedOn;
	
	public BoardVisit(ObjectId boardId,Date lastVisitedOn){
		this.boardId = boardId;
		this.lastVisitedOn = lastVisitedOn;
	}
}

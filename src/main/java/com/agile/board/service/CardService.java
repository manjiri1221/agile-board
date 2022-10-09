package com.agile.board.service;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.agile.board.dao.CardDao;
import com.agile.board.entity.Card;

import reactor.core.publisher.Mono;

/**
 * Service class for card operations
 * @author manjirilakhote
 *
 */
@Service
public class CardService {
	
	@Autowired
	CardDao cardDao;

	public Mono<Card> createCard(String name, ObjectId columnId, int sequence, ObjectId createdBy) throws Exception {
		if(StringUtils.hasLength(name) && columnId!=null && createdBy!=null) {
			Card card = new Card(name,columnId,sequence,createdBy);
			return cardDao.save(card);
		}
		throw new Exception("Name or columnId or createdBy is null or empty");
	}
	
	

}
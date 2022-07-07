package com.java.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.java.entity.Song;

public class AlbumSongDao  extends GenericDao{
	
	public List<Song> fetchSongSungBy(String artist){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("funkopop");
		try {
			EntityManager em = emf.createEntityManager();
			Query q = em.createQuery("select s from Song s where s.artist = :artist");
			q.setParameter("artist", artist);
			List<Song> list = q.getResultList();
			return list;
		}
		finally {
			emf.close();
		}
	}
}

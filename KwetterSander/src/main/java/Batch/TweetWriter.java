/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Batch;

import java.util.List;
import javax.batch.api.chunk.AbstractItemWriter;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import Model.Tweet;

/**
 *
 * @author Sander
 */ 
@Dependent
@Named
public class TweetWriter extends AbstractItemWriter {
    
    @PersistenceContext
    EntityManager em;

    @Override
    public void writeItems(List<Object> items) throws Exception {
        @SuppressWarnings("unchecked")
        List<Tweet> tweets = (List<Tweet>) (List<?>) items;
        for (Tweet tweet : tweets) {
            em.persist(tweet);
        }
    }
}

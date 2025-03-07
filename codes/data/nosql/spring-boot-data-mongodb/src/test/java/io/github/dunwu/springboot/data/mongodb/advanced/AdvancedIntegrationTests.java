package io.github.dunwu.springboot.data.mongodb.advanced;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import io.github.dunwu.springboot.data.mongodb.DataMongodbApplication;
import io.github.dunwu.springboot.data.mongodb.customer.Customer;
import org.bson.Document;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Meta;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Christoph Strobl
 * @author Oliver Gierke
 */
@SpringBootTest
public class AdvancedIntegrationTests {

    @Autowired
    AdvancedRepository repository;
    @Autowired
    MongoOperations operations;

    Customer dave, oliver, carter;

    @BeforeEach
    public void setUp() {

        repository.deleteAll();

        dave = repository.save(new Customer("Dave", "Matthews"));
        oliver = repository.save(new Customer("Oliver August", "Matthews"));
        carter = repository.save(new Customer("Carter", "Beauford"));
    }

    /**
     * This test demonstrates usage of {@code $comment} {@link Meta} usage. One can also enable profiling using {@code
     * --profile=2} when starting {@literal mongod}.
     * <p>
     * <strong>NOTE</strong>: Requires MongoDB v. 2.6.4+
     */
    @Test
    public void findByFirstnameUsingMetaAttributes() {

        // execute derived finder method just to get the comment in the profile log
        repository.findByFirstname(dave.getFirstname());

        // execute another finder without meta attributes that should not be picked up
        repository.findByLastname(dave.getLastname(), Sort.by("firstname"));

        FindIterable<Document> cursor = operations.getCollection(DataMongodbApplication.SYSTEM_PROFILE_DB)
                                                  .find(new BasicDBObject("query.$comment",
                                                      AdvancedRepository.META_COMMENT));

        for (Document document : cursor) {

            Document query = (Document) document.get("query");
            assertThat(query).containsKey("foo");
        }
    }

}

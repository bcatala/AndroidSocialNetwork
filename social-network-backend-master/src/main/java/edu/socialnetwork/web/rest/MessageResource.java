package edu.socialnetwork.web.rest;
import edu.socialnetwork.domain.Message;
import edu.socialnetwork.service.MessageService;
import edu.socialnetwork.web.rest.errors.BadRequestAlertException;
import edu.socialnetwork.web.rest.util.HeaderUtil;
import edu.socialnetwork.web.rest.util.PaginationUtil;
import edu.socialnetwork.service.dto.MessageCriteria;
import edu.socialnetwork.service.MessageQueryService;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Message.
 */
@RestController
@RequestMapping("/api")
public class MessageResource {

    private final Logger log = LoggerFactory.getLogger(MessageResource.class);

    private static final String ENTITY_NAME = "message";

    private final MessageService messageService;

    private final MessageQueryService messageQueryService;

    public MessageResource(MessageService messageService, MessageQueryService messageQueryService) {
        this.messageService = messageService;
        this.messageQueryService = messageQueryService;
    }

    /**
     * POST  /messages : Create a new message.
     *
     * @param message the message to create
     * @return the ResponseEntity with status 201 (Created) and with body the new message, or with status 400 (Bad Request) if the message has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/messages")
    public ResponseEntity<Message> createMessage(@Valid @RequestBody Message message) throws URISyntaxException {
        log.debug("REST request to save Message : {}", message);
        if (message.getId() != null) {
            throw new BadRequestAlertException("A new message cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Message result = messageService.save(message);
        return ResponseEntity.created(new URI("/api/messages/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /messages : Updates an existing message.
     *
     * @param message the message to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated message,
     * or with status 400 (Bad Request) if the message is not valid,
     * or with status 500 (Internal Server Error) if the message couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/messages")
    public ResponseEntity<Message> updateMessage(@Valid @RequestBody Message message) throws URISyntaxException {
        log.debug("REST request to update Message : {}", message);
        if (message.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        Message result = messageService.save(message);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, message.getId().toString()))
            .body(result);
    }

    /**
     * GET  /messages : get all the messages.
     *
     * @param pageable the pagination information
     * @param criteria the criterias which the requested entities should match
     * @return the ResponseEntity with status 200 (OK) and the list of messages in body
     */
    @GetMapping("/messages")
    public ResponseEntity<List<Message>> getAllMessages(MessageCriteria criteria, Pageable pageable) {
        log.debug("REST request to get Messages by criteria: {}", criteria);
        Page<Message> page = messageQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/messages");
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
    * GET  /messages/count : count all the messages.
    *
    * @param criteria the criterias which the requested entities should match
    * @return the ResponseEntity with status 200 (OK) and the count in body
    */
    @GetMapping("/messages/count")
    public ResponseEntity<Long> countMessages(MessageCriteria criteria) {
        log.debug("REST request to count Messages by criteria: {}", criteria);
        return ResponseEntity.ok().body(messageQueryService.countByCriteria(criteria));
    }

    /**
     * GET  /messages/:id : get the "id" message.
     *
     * @param id the id of the message to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the message, or with status 404 (Not Found)
     */
    @GetMapping("/messages/{id}")
    public ResponseEntity<Message> getMessage(@PathVariable Long id) {
        log.debug("REST request to get Message : {}", id);
        Optional<Message> message = messageService.findOne(id);
        return ResponseUtil.wrapOrNotFound(message);
    }

    /**
     * DELETE  /messages/:id : delete the "id" message.
     *
     * @param id the id of the message to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/messages/{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable Long id) {
        log.debug("REST request to delete Message : {}", id);
        messageService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}

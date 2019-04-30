package edu.socialnetwork.service.dto;

import java.io.Serializable;
import java.util.Objects;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.DoubleFilter;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.FloatFilter;
import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;
import io.github.jhipster.service.filter.ZonedDateTimeFilter;

/**
 * Criteria class for the Invitation entity. This class is used in InvitationResource to
 * receive all the possible filtering options from the Http GET request parameters.
 * For example the following could be a valid requests:
 * <code> /invitations?id.greaterThan=5&amp;attr1.contains=something&amp;attr2.specified=false</code>
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class InvitationCriteria implements Serializable {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private ZonedDateTimeFilter createdDate;

    private BooleanFilter accepted;

    private LongFilter sentId;

    private LongFilter receivedId;

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public ZonedDateTimeFilter getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(ZonedDateTimeFilter createdDate) {
        this.createdDate = createdDate;
    }

    public BooleanFilter getAccepted() {
        return accepted;
    }

    public void setAccepted(BooleanFilter accepted) {
        this.accepted = accepted;
    }

    public LongFilter getSentId() {
        return sentId;
    }

    public void setSentId(LongFilter sentId) {
        this.sentId = sentId;
    }

    public LongFilter getReceivedId() {
        return receivedId;
    }

    public void setReceivedId(LongFilter receivedId) {
        this.receivedId = receivedId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final InvitationCriteria that = (InvitationCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(createdDate, that.createdDate) &&
            Objects.equals(accepted, that.accepted) &&
            Objects.equals(sentId, that.sentId) &&
            Objects.equals(receivedId, that.receivedId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        createdDate,
        accepted,
        sentId,
        receivedId
        );
    }

    @Override
    public String toString() {
        return "InvitationCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (createdDate != null ? "createdDate=" + createdDate + ", " : "") +
                (accepted != null ? "accepted=" + accepted + ", " : "") +
                (sentId != null ? "sentId=" + sentId + ", " : "") +
                (receivedId != null ? "receivedId=" + receivedId + ", " : "") +
            "}";
    }

}

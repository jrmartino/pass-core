/*
 * Copyright 2018 Johns Hopkins University
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.eclipse.pass.object.model;

import java.net.URI;
import java.time.ZonedDateTime;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.yahoo.elide.annotation.Include;
import org.eclipse.pass.object.converter.EventTypeToStringConverter;
import org.eclipse.pass.object.converter.PerformerRoleToStringConverter;

/**
 * The SubmissionEvent model captures significant events that are performed by an agent and occur against a Submission.
 *
 * @author Karen Hanson
 */

@Include
@Entity
@Table(name = "pass_submission_event")
public class SubmissionEvent extends PassEntity {

    /**
     * The type of event
     */
    @Convert(converter = EventTypeToStringConverter.class)
    private EventType eventType;

    /**
     * Date the event was performed by the User
     */

    private ZonedDateTime performedDate;

    /**
     * The User responsible for performing the event
     */
    @ManyToOne
    private User performedBy;

    /**
     * Role of the person performing the event
     */
    @Convert(converter = PerformerRoleToStringConverter.class)
    private PerformerRole performerRole;

    /**
     * Associated submission.
     */
    @ManyToOne
    private Submission submission;

    /**
     * A comment relevant to the SubmissionEvent. For example, when a `changes-requested` event occurs,
     * this might be added by the User through the UI to communicate what changes should be made
     */
    private String comment;

    /**
     * A resource relevant to the SubmissionEvent. For example, when a `changes-requested` event occurs,
     * this may contain an Ember application URL to the affected Submission.
     */
    private URI link;

    /**
     * SubmissionEvent constructor
     */
    public SubmissionEvent() {
    }

    /**
     * Copy constructor, this will copy the values of the object provided into the new object
     *
     * @param submissionEvent the submissionEvent to copy
     */
    public SubmissionEvent(SubmissionEvent submissionEvent) {
        super(submissionEvent);
        this.eventType = submissionEvent.eventType;
        this.performedDate = submissionEvent.performedDate;
        this.performedBy = submissionEvent.performedBy;
        this.performerRole = submissionEvent.performerRole;
        this.submission = submissionEvent.submission;
        this.comment = submissionEvent.comment;
        this.link = submissionEvent.link;
    }

    /**
     * @return the eventType
     */
    public EventType getEventType() {
        return eventType;
    }

    /**
     * @param eventType the eventType to set
     */
    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    /**
     * @return the performedDate
     */
    public ZonedDateTime getPerformedDate() {
        return performedDate;
    }

    /**
     * @param performedDate the performedDate to set
     */
    public void setPerformedDate(ZonedDateTime performedDate) {
        this.performedDate = performedDate;
    }

    /**
     * @return the performedBy
     */
    public User getPerformedBy() {
        return performedBy;
    }

    /**
     * @param performedBy the performedBy to set
     */
    public void setPerformedBy(User performedBy) {
        this.performedBy = performedBy;
    }

    /**
     * @return the performerRole
     */
    public PerformerRole getPerformerRole() {
        return performerRole;
    }

    /**
     * @param performerRole the performerRole to set
     */
    public void setPerformerRole(PerformerRole performerRole) {
        this.performerRole = performerRole;
    }

    /**
     * @return the submission
     */
    public Submission getSubmission() {
        return submission;
    }

    /**
     * @param submission the submission to set
     */
    public void setSubmission(Submission submission) {
        this.submission = submission;
    }

    /**
     * @return the comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment the comment to set
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * @return the link
     */
    public URI getLink() {
        return link;
    }

    /**
     * @param link the link to set
     */
    public void setLink(URI link) {
        this.link = link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        SubmissionEvent that = (SubmissionEvent) o;

        if (eventType != null ? !eventType.equals(that.eventType) : that.eventType != null) {
            return false;
        }
        if (performedDate != null ? !performedDate.equals(that.performedDate) : that.performedDate != null) {
            return false;
        }
        if (performedBy != null ? !performedBy.equals(that.performedBy) : that.performedBy != null) {
            return false;
        }
        if (performerRole != null ? !performerRole.equals(that.performerRole) : that.performerRole != null) {
            return false;
        }
        if (submission != null ? !submission.equals(that.submission) : that.submission != null) {
            return false;
        }
        if (comment != null ? !comment.equals(that.comment) : that.comment != null) {
            return false;
        }
        if (link != null ? !link.equals(that.link) : that.link != null) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (eventType != null ? eventType.hashCode() : 0);
        result = 31 * result + (performedDate != null ? performedDate.hashCode() : 0);
        result = 31 * result + (performedBy != null ? performedBy.hashCode() : 0);
        result = 31 * result + (performerRole != null ? performerRole.hashCode() : 0);
        result = 31 * result + (submission != null ? submission.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (link != null ? link.hashCode() : 0);
        return result;
    }
}

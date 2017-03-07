package seedu.address.model.person;

import java.util.Date;
import java.util.Objects;

import seedu.address.commons.util.CollectionUtil;
import seedu.address.model.tag.UniqueTagList;

public class Task implements ReadOnlyTask{
    public String taskName;
    public Date startDate, endDate;
    
    private UniqueTagList tags;
    
    /**
     * Every field must be present and not null.
     */
    public Task(String taskName, Date startDate, Date endDate, UniqueTagList tags){
        assert !CollectionUtil.isAnyNull(taskName, startDate, endDate, tags);
        this.taskName = taskName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.tags = tags;
    }
    
    /**
     * Creates a copy of the given ReadOnlyTask.
     */
    public Task(ReadOnlyTask source) {
        this(source.getTaskName(), source.getStartDate(), source.getEndDate(), source.getTags());
    }
    
    /**
     * Updates this taask with the details of {@code replacement}.
     */
    public void resetData(ReadOnlyTask replacement){
        assert replacement!=null;
        
        this.taskName = replacement.getTaskName();
        this.startDate = replacement.getStartDate();
        this.endDate = replacement.getEndDate();
        this.tags = replacement.getTags();
    }
    
    @Override
    public Date getStartDate(){
        return startDate;
    }
    
    @Override
    public Date getEndDate(){
        return endDate;
    }
    
    public void setStartDate(Date startDate){
        this.startDate = startDate;
    }
    
    public void setEndDate(Date endDate){
        this.endDate = endDate;
    }
    
    /**
     * Replaces this person's tags with the tags in the argument tag list.
     */
    public void setTags(UniqueTagList replacement) {
        tags.setTags(replacement);
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public UniqueTagList getTags() {
        return tags;
    }
    
    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof ReadOnlyTask // instanceof handles nulls
                && this.isSameStateAs((ReadOnlyTask) other));
    }

    
    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(taskName, startDate, endDate, tags);
    }

    @Override
    public String toString() {
        return getAsText();
    }

}

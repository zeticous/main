package seedu.address.testutil;

import java.util.Date;

import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Phone;
import seedu.address.model.person.ReadOnlyTask;
import seedu.address.model.tag.UniqueTagList;

/**
 * A mutable person object. For testing only.
 */
public class TestTask implements ReadOnlyTask {

    private String taskName;
    private Date startDate, endDate;
    
    private UniqueTagList tags;

    public TestTask() {
        tags = new UniqueTagList();
    }

    /**
     * Creates a copy of {@code personToCopy}.
     */
    public TestTask(TestTask personToCopy) {
        this.taskName = personToCopy.getTaskName();
        this.startDate = personToCopy.getStartDate();
        this.endDate = personToCopy.getEndDate();
        this.tags = personToCopy.getTags();
    }

    @Override
    public Date getStartDate(){
        return startDate;
    }
    
    @Override
    public Date getEndDate(){
        return endDate;
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public UniqueTagList getTags() {
        return tags;
    }

    public String getAddCommand() {
        StringBuilder sb = new StringBuilder();
        sb.append("add " + this.getTaskName() + " ");
        sb.append("from:" + this.getStartDate() + " ");
        sb.append("to:" + this.getEndDate() + " ");
        this.getTags().asObservableList().stream().forEach(s -> sb.append("t/" + s.tagName + " "));
        return sb.toString();
    }
    

    public void setStartDate(Date startDate){
        this.startDate = startDate;
    }
    
    public void setEndDate(Date endDate){
        this.endDate = endDate;
    }
    
    public void setTaskName(String name){
        this.taskName = name;
    }
    
    /**
     * Replaces this person's tags with the tags in the argument tag list.
     */
    public void setTags(UniqueTagList replacement) {
        tags.setTags(replacement);
    }

}

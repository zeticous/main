package seedu.address.model.person;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

import seedu.address.commons.util.CollectionUtil;
import seedu.address.model.tag.Tag;
import seedu.address.model.tag.UniqueTagList;

public class Task implements ReadOnlyTask{
    private String taskName;
    private Date startDate, endDate;
    
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY hh:mm");
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
     * Parse dateStrings into startDate and endDate.
     * @param taskName
     * @param startDateString, format follows dateFormat above.
     * @param endDateString, format follows dateFormat above.
     * @param tags
     * @throws ParseException
     * @TODO create a separate parser for dates by reading a config file.
     */
    public Task(String taskName, String startDateString, String endDateString, Set<Tag> tags) throws ParseException{
        this(taskName, dateFormat.parse(startDateString),dateFormat.parse(endDateString),new UniqueTagList(tags));
    }
    
    public Task(String taskName, String startDateString, String endDateString, UniqueTagList tags) throws ParseException{
        this(taskName, parseDate(startDateString),parseDate(endDateString), tags);
    }
    
    
    /**
     * TODO: Create a date parser class.
     * Temporary hot-fix to parse date to appropriate format
     * @throws ParseException 
     */
    public static Date parseDate(String dateString) throws ParseException{
        return dateFormat.parse(dateString);
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
    
    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public UniqueTagList getTags() {
        return tags;
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

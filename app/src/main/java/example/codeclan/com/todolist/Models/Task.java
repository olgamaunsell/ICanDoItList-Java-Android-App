package example.codeclan.com.todolist.Models;

import java.io.Serializable;

import example.codeclan.com.todolist.Enums.RagStatus;

/**
 * Created by admin on 27/01/2018.
 */

public class Task implements Serializable {

    private String name;
    private String description;
    private Boolean complete;
    private Boolean priority;
    private Boolean archived;
    private RagStatus ragStatus;


    public Task(String name, String description, Boolean priority){

//    todo - temporarily taken out ragstatus until decide to use ?
// public Task(String name, String description, Boolean priority, RagStatus ragStatus){
        this.name = name;
        this.description = description;
        this.priority = priority;
//        this.ragStatus = ragStatus;
        this.complete = false;
        this.archived = false;
    }

//    Getters
    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

//    public RagStatus getRagStatus() {
//        return this.ragStatus;
//    }

    public boolean isPriority() {
        return this.priority;
    }

    public boolean isComplete() {
        return this.complete;
    }

    public boolean isArchived() {
        return this.archived;
    }

//   Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPriority(boolean priority) {
        this.priority = priority;
    }

//    public void setRagStatus(RagStatus ragStatus) {
//        this.ragStatus = ragStatus;
//    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public boolean isNameEmpty() {

        if (this.name == null || this.name.trim().length() == 0) {
            return true;
        }
        else {
            return false;
        }
    }
}

package com.arun.myapp.storage.sqlroom;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@androidx.room.Dao
public interface Dao {

    @Insert
    void insert(CourseModal modal);

    @Update
    void update(CourseModal modal);

    @Delete
    void delete(CourseModal modal);

    @Query("DELETE FROM course_table")
    void deleteAllCourses();

    @Query("SELECT * FROM course_table ORDER BY courseName ASC")
    LiveData<List<CourseModal>> getAllCourses();
}

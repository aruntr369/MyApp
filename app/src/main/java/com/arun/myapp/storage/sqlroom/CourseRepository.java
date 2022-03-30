package com.arun.myapp.storage.sqlroom;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class CourseRepository {

    private  Dao dao;
    private LiveData<List<CourseModal>> allCourses;

    public CourseRepository(Application application) {
        CourseDatabase database = CourseDatabase.getInstance(application);
        this.dao = database.Dao();
        this.allCourses = dao.getAllCourses();
    }
    public void insert(CourseModal model) {
        new InsertCourseAsyncTask(dao).execute(model);
    }

    public void update(CourseModal modal){
        new UpdateCourseAsyncTask(dao).execute(modal);
    }

    public void delete(CourseModal model) {
        new DeleteCourseAsyncTask(dao).execute(model);
    }

    public void deleteAllCourses() {
        new DeleteAllCoursesAsyncTask(dao).execute();
    }

    public LiveData<List<CourseModal>> getAllCourses() {
        return allCourses;
    }



    private static class InsertCourseAsyncTask extends AsyncTask<CourseModal, Void, Void> {
        private Dao dao;

        private InsertCourseAsyncTask(Dao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(CourseModal... model) {
            // below line is use to insert our modal in dao.
            dao.insert(model[0]);
            return null;
        }
    }

    private static class UpdateCourseAsyncTask extends AsyncTask<CourseModal,Void,Void> {
        private  Dao dao;

        private UpdateCourseAsyncTask(Dao dao) {
            this.dao = dao;
        }
        @Override
        protected Void doInBackground(CourseModal... courseModals) {
            dao.update(courseModals[0]);
            return null;
        }
    }
    private static class DeleteCourseAsyncTask extends AsyncTask<CourseModal, Void, Void> {
        private Dao dao;

        private DeleteCourseAsyncTask(Dao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(CourseModal... models) {
            // below line is use to delete
            // our course modal in dao.
            dao.delete(models[0]);
            return null;
        }
    }

    private static class DeleteAllCoursesAsyncTask extends AsyncTask<Void, Void, Void> {
        private Dao dao;
        private DeleteAllCoursesAsyncTask(Dao dao) {
            this.dao = dao;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            // on below line calling method
            // to delete all courses.
            dao.deleteAllCourses();
            return null;
        }
    }
}

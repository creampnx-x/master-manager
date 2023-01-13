package com.example.mastermanager.module1.DAO;



public class DAOFactory {
    private static com.example.mastermanager.module1.DAO.DAOFactory daoFactory;
    static {
        daoFactory = new com.example.mastermanager.module1.DAO.DAOFactory();
    }
    private DAOFactory(){

    }

    public static com.example.mastermanager.module1.DAO.DAOFactory getInstance(){
        return daoFactory;
    }

    public UserDao getUserDAO(){
        return new UserDaoImpl();
    }
    public StudentDao getStudentDAO() {return new StudentDaoImpl();}
    public CourseDao getCourseDAO() {return new CourseDaoImpl();}
    public ChooseDAO getChooseDAO() {return new ChooseDAOImpl();}
    public EvaluateDAO getEvaluateDAO() {return new EvaluateDAOImpl();}

}
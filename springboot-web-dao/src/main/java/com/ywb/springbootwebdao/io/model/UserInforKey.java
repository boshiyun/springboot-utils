package com.ywb.springbootwebdao.io.model;

public class UserInforKey {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_infor.USER_ID
     *
     * @mbg.generated
     */
    private Long userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_infor.ID_NUMBER
     *
     * @mbg.generated
     */
    private String idNumber;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_infor.USER_ID
     *
     * @return the value of user_infor.USER_ID
     *
     * @mbg.generated
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_infor.USER_ID
     *
     * @param userId the value for user_infor.USER_ID
     *
     * @mbg.generated
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_infor.ID_NUMBER
     *
     * @return the value of user_infor.ID_NUMBER
     *
     * @mbg.generated
     */
    public String getIdNumber() {
        return idNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_infor.ID_NUMBER
     *
     * @param idNumber the value for user_infor.ID_NUMBER
     *
     * @mbg.generated
     */
    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber == null ? null : idNumber.trim();
    }
}
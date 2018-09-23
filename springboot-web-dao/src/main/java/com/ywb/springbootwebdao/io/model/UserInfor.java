package com.ywb.springbootwebdao.io.model;

public class UserInfor extends UserInforKey {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_infor.USER_NAME
     *
     * @mbg.generated
     */
    private String userName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_infor.MOBILE
     *
     * @mbg.generated
     */
    private String mobile;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_infor.BANK_CARD_NUMBER
     *
     * @mbg.generated
     */
    private String bankCardNumber;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_infor.SEX
     *
     * @mbg.generated
     */
    private String sex;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_infor.IS_ADULT
     *
     * @mbg.generated
     */
    private String isAdult;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_infor.USER_NAME
     *
     * @return the value of user_infor.USER_NAME
     *
     * @mbg.generated
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_infor.USER_NAME
     *
     * @param userName the value for user_infor.USER_NAME
     *
     * @mbg.generated
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_infor.MOBILE
     *
     * @return the value of user_infor.MOBILE
     *
     * @mbg.generated
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_infor.MOBILE
     *
     * @param mobile the value for user_infor.MOBILE
     *
     * @mbg.generated
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_infor.BANK_CARD_NUMBER
     *
     * @return the value of user_infor.BANK_CARD_NUMBER
     *
     * @mbg.generated
     */
    public String getBankCardNumber() {
        return bankCardNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_infor.BANK_CARD_NUMBER
     *
     * @param bankCardNumber the value for user_infor.BANK_CARD_NUMBER
     *
     * @mbg.generated
     */
    public void setBankCardNumber(String bankCardNumber) {
        this.bankCardNumber = bankCardNumber == null ? null : bankCardNumber.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_infor.SEX
     *
     * @return the value of user_infor.SEX
     *
     * @mbg.generated
     */
    public String getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_infor.SEX
     *
     * @param sex the value for user_infor.SEX
     *
     * @mbg.generated
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_infor.IS_ADULT
     *
     * @return the value of user_infor.IS_ADULT
     *
     * @mbg.generated
     */
    public String getIsAdult() {
        return isAdult;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_infor.IS_ADULT
     *
     * @param isAdult the value for user_infor.IS_ADULT
     *
     * @mbg.generated
     */
    public void setIsAdult(String isAdult) {
        this.isAdult = isAdult == null ? null : isAdult.trim();
    }
}
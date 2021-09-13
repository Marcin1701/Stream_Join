package polsl.stream.join.data.model;

public class Config {

    /**
     * Name of first CSV file to process
     */
    private String firstFile;

    /**
     * Name of second CSV file to process
     */
    private String secondFile;

    /**
     * Time between stream inits in ms
     */
    private Integer dataLifespan;

    /**
     * Automatic simulation
     */
    private Boolean automatic;

    /**
     * Type of join operation
     */
    private String joinType;

    /**
     * Name of the column to join
     */
    private String joinColumn;

    /**
     * Condition of theta join
     */
    private String thetaJoinType;

    public String getFirstFile() {
        return firstFile;
    }

    public String getSecondFile() {
        return secondFile;
    }

    public Integer getDataLifespan() {
        return dataLifespan;
    }

    public Boolean getAutomatic() {
        return automatic;
    }

    public String getJoinType() {
        return joinType;
    }

    public void setFirstFile(String firstFile) {
        this.firstFile = firstFile;
    }

    public void setSecondFile(String secondFile) {
        this.secondFile = secondFile;
    }

    public void setDataLifespan(Integer dataLifespan) {
        this.dataLifespan = dataLifespan;
    }

    public void setAutomatic(Boolean automatic) {
        this.automatic = automatic;
    }

    public void setJoinType(String joinType) {
        this.joinType = joinType;
    }

    public String getJoinColumn() {
        return joinColumn;
    }

    public void setJoinColumn(String joinColumn) {
        this.joinColumn = joinColumn;
    }

    public String getThetaJoinType() {
        return thetaJoinType;
    }

    public void setThetaJoinType(String thetaJoinType) {
        this.thetaJoinType = thetaJoinType;
    }
}

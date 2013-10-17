package ca.bcit.infosys.a1.model;

/**
 * The utility class Hours.
 *
 * @author jhou
 * @version 0.1
 */
public class Hours {

    /** The sat. */
    private double sat;

    /** The sun. */
    private double sun;

    /** The mon. */
    private double mon;

    /** The tue. */
    private double tue;

    /** The wed. */
    private double wed;

    /** The thu. */
    private double thu;

    /** The fri. */
    private double fri;

    /**
     * Gets the sat.
     *
     * @return the sat
     */
    public double getSat() {
        return sat;
    }

    /**
     * Sets the sat.
     *
     * @param sat
     *            the new sat
     */
    public void setSat(final double sat) {
        this.sat = sat;
    }

    /**
     * Gets the sun.
     *
     * @return the sun
     */
    public double getSun() {
        return sun;
    }

    /**
     * Sets the sun.
     *
     * @param sun
     *            the new sun
     */
    public void setSun(final double sun) {
        this.sun = sun;
    }

    /**
     * Gets the mon.
     *
     * @return the mon
     */
    public double getMon() {
        return mon;
    }

    /**
     * Sets the mon.
     *
     * @param mon
     *            the new mon
     */
    public void setMon(final double mon) {
        this.mon = mon;
    }

    /**
     * Gets the tue.
     *
     * @return the tue
     */
    public double getTue() {
        return tue;
    }

    /**
     * Sets the tue.
     *
     * @param tue
     *            the new tue
     */
    public void setTue(final double tue) {
        this.tue = tue;
    }

    /**
     * Gets the wed.
     *
     * @return the wed
     */
    public double getWed() {
        return wed;
    }

    /**
     * Sets the wed.
     *
     * @param wed
     *            the new wed
     */
    public void setWed(final double wed) {
        this.wed = wed;
    }

    /**
     * Gets the thu.
     *
     * @return the thu
     */
    public double getThu() {
        return thu;
    }

    /**
     * Sets the thu.
     *
     * @param thu
     *            the new thu
     */
    public void setThu(final double thu) {
        this.thu = thu;
    }

    /**
     * Gets the fri.
     *
     * @return the fri
     */
    public double getFri() {
        return fri;
    }

    /**
     * Sets the fri.
     *
     * @param fri
     *            the new fri
     */
    public void setFri(final double fri) {
        this.fri = fri;
    }

    /**
     * Gets the total.
     *
     * @return the total
     */
    public double getTotal() {
        return sat + sun + mon + tue + wed + thu + fri;
    }

}

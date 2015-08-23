package com.ats.property.common.constants;

/**
 * The PropertyConstants.
 *
 * @author anbarasan.s
 */
public enum PropertyConstants {
    USER("USER"),
    PLAN_DAYS_PLACEHOLDER("\\{days}"),
    PLAN_COST_PLACEHOLDER("\\{plancost}"),
    MAX_IMAGE_PLACEHOLDER("\\{maxphoto}");

    private final String value;

    private PropertyConstants(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}

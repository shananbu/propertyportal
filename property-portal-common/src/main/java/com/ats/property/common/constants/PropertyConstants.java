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
    MAX_IMAGE_PLACEHOLDER("\\{maxphoto}"),
    LAKHS("Lakhs"),
    ONWARDS("onwards"),
    EXTERIOR_VIEW("EXTERIOR_VIEW"),
    RESOURCE_DIR("propertyResources/");


    private final String value;

    private PropertyConstants(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}

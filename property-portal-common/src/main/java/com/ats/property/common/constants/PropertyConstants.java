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
    RESOURCE_DIR("/propertyResources/"),
    NO_IMAGE_PATH("images/no_image.jpg"),
    LOGO("LOGO"),
    CLASSIFIEDS("Classifieds"),
    MICROSITE("Microsite"),
    APPROVED("Approved"),
    APPROVAL_PENDING("Pending for Approval"),
    USER_BUILDER("Builder");

    private final String value;

    private PropertyConstants(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}

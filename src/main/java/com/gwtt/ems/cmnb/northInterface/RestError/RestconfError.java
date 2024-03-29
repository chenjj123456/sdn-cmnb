package com.gwtt.ems.cmnb.northInterface.RestError;

import com.google.common.base.Preconditions;

import javax.xml.bind.annotation.XmlElement;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Encapsulates a restconf error as defined in the ietf restconf draft.
 *
 * <br>
 * <br>
 * <b>Note:</b> Enumerations defined within are provided by the ietf restconf draft.
 *
 * @author Devin Avery See also <a href="https://tools.ietf.org/html/draft-bierman-netconf-restconf-02">RESTCONF</a>.
 */
public class RestconfError {

    public static enum ErrorType {
        /**
         * Errors relating to the transport layer
         */
        TRANSPORT,
        /**
         * Errors relating to the RPC or notification layer
         */
        RPC,
        /**
         * Errors relating to the protocol operation layer.
         */
        PROTOCOL,
        /**
         * Errors relating to the server application layer.
         */
        APPLICATION;

        public String getErrorTypeTag() {
            return name().toLowerCase();
        }

        public static ErrorType valueOfCaseInsensitive(String value) {
            try {
                return ErrorType.valueOf(ErrorType.class, value.toUpperCase());
            } catch (IllegalArgumentException e) {
                return APPLICATION;
            }
        }
    }

    public static enum ErrorTag {
        IN_USE("in-use", 409 /* Conflict */),
        INVALID_VALUE("invalid-value", 400 /* Bad Request */),
        TOO_BIG("too-big", 413 /* Request Entity Too Large */),
        MISSING_ATTRIBUTE("missing-attribute", 400 /* Bad Request */),
        BAD_ATTRIBUTE("bad-attribute", 400 /* Bad Request */),
        UNKNOWN_ATTRIBUTE("unknown-attribute", 400 /* Bad Request */),
        MISSING_ELEMENT("missing-element", 400 /* Bad Request */),
        BAD_ELEMENT("bad-element", 400 /* Bad Request */),
        UNKNOWN_ELEMENT("unknown-element", 400 /* Bad Request */),
        UNKNOWN_NAMESPACE("unknown-namespace", 400 /* Bad Request */),
        ACCESS_DENIED("access-denied", 403 /* Forbidden */),
        LOCK_DENIED("lock-denied", 409 /* Conflict */),
        RESOURCE_DENIED("resource-denied", 409 /* Conflict */),
        ROLLBACK_FAILED("rollback-failed", 500 /* INTERNAL_SERVER_ERROR */),
        DATA_EXISTS("data-exists", 409 /* Conflict */),
        DATA_MISSING("data-missing", 404 /* Resource Not Found */),
        OPERATION_NOT_SUPPORTED("operation-not-supported", 501 /* Not Implemented */),
        OPERATION_FAILED("operation-failed", 500 /* INTERNAL_SERVER_ERROR */),
        PARTIAL_OPERATION("partial-operation", 500 /* INTERNAL_SERVER_ERROR */),
        MALFORMED_MESSAGE("malformed-message", 400 /* Bad Request */);

        private final String tagValue;
        private final int statusCode;

        ErrorTag(final String tagValue, final int statusCode) {
            this.tagValue = tagValue;
            this.statusCode = statusCode;
        }

        public String getTagValue() {
            return this.tagValue.toLowerCase();
        }

        public static ErrorTag valueOfCaseInsensitive(String value) {
            try {
                return ErrorTag.valueOf(ErrorTag.class, value.toUpperCase().replaceAll("-", "_"));
            } catch (IllegalArgumentException e) {
                return OPERATION_FAILED;
            }
        }

        public int getStatusCode() {
            return statusCode;
        }
    }

    @XmlElement(name = "error-type")
    private final ErrorType errorType;
    @XmlElement(name = "error-tag")
    private final ErrorTag errorTag;
    @XmlElement(name = "error-info")
    private final String errorInfo;
    @XmlElement(name = "error-app-tag")
    private final String errorAppTag;
    @XmlElement(name = "error-message")
    private final String errorMessage;

    // TODO: Add in the error-path concept as defined in the ietf draft.
    static String toErrorInfo(Throwable cause) {
        StringWriter writer = new StringWriter();
        cause.printStackTrace(new PrintWriter(writer));
        return writer.toString();
    }

    /**
     * Constructs a RestConfError
     *
     * @param errorType The enumerated type indicating the layer where the error occurred.
     * @param errorTag The enumerated tag representing a more specific error cause.
     * @param errorMessage A string which provides a plain text string describing the error.
     */
    public RestconfError(ErrorType errorType, ErrorTag errorTag, String errorMessage) {
        this(errorType, errorTag, errorMessage, null);
    }

    /**
     * Constructs a RestConfError object.
     *
     * @param errorType The enumerated type indicating the layer where the error occurred.
     * @param errorTag The enumerated tag representing a more specific error cause.
     * @param errorMessage A string which provides a plain text string describing the error.
     * @param errorAppTag A string which represents an application-specific error tag that further specifies the error
     * cause.
     */
    public RestconfError(ErrorType errorType, ErrorTag errorTag, String errorMessage, String errorAppTag) {
        this(errorType, errorTag, errorMessage, errorAppTag, null);
    }

    /**
     * Constructs a RestConfError object.
     *
     * @param errorType The enumerated type indicating the layer where the error occurred.
     * @param errorTag The enumerated tag representing a more specific error cause.
     * @param errorMessage A string which provides a plain text string describing the error.
     * @param errorAppTag A string which represents an application-specific error tag that further specifies the error
     * cause.
     * @param errorInfo A string, <b>formatted as XML</b>, which contains additional error information.
     */
    public RestconfError(ErrorType errorType, ErrorTag errorTag, String errorMessage, String errorAppTag,
                         String errorInfo) {
        Preconditions.checkNotNull(errorType, "Error type is required for RestConfError");
        Preconditions.checkNotNull(errorTag, "Error tag is required for RestConfError");
        this.errorType = errorType;
        this.errorTag = errorTag;
        this.errorMessage = errorMessage;
        this.errorAppTag = errorAppTag;
        this.errorInfo = errorInfo;
    }

    public ErrorType getErrorType() {
        return errorType;
    }

    public ErrorTag getErrorTag() {
        return errorTag;
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public String getErrorAppTag() {
        return errorAppTag;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public String toString() {
        return "error-type: " + errorType.getErrorTypeTag() + ", error-tag: " + errorTag.getTagValue() + ", "
                + (errorAppTag != null ? "error-app-tag: " + errorAppTag + ", " : "")
                + (errorMessage != null ? "error-message: " + errorMessage : "")
                + (errorInfo != null ? "error-info: " + errorInfo + ", " : "") + "]";
    }

}

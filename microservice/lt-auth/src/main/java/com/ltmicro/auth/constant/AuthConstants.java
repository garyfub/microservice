package com.ltmicro.auth.constant;

public interface AuthConstants {

    String LICENSE = "made by louis";
    String REDIS_PREFIX = "ltauth_";

    String SQL_CLIENT_FIELDS = "client_id, client_secret, resource_ids, scope, "
            + "authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, "
            + "refresh_token_validity, additional_information, autoapprove";
    String SQL_FIND_CLIENT_DETAILS_BASE = "select " + SQL_CLIENT_FIELDS
            + " from sys_oauth_client_details";
    String SQL_FIND_CLIENT_DETAILS = SQL_FIND_CLIENT_DETAILS_BASE + " order by client_id";
    String SQL_SELECT_CLIENT_DETAILS = SQL_FIND_CLIENT_DETAILS_BASE + " where client_id = ?";

}

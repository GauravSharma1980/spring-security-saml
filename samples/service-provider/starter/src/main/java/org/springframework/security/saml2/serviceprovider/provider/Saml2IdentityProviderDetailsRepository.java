package org.springframework.security.saml2.serviceprovider.provider;

/**
 * Resolves a configured remote provider by entityId or alias
 */
public interface Saml2IdentityProviderDetailsRepository {

	/**
	 * Resolves an entity provider by entityId
	 * @param idpEntityId - unique entityId for the remote identity provider, not null
	 * @return a configured remote identity provider, or null if none found
	 */
	Saml2RelyingPartyRegistration findByEntityId(String idpEntityId);

	/**
	 * Resolves an entity provider by entityId
	 * @param alias - unique alias, not null
	 * @return a configured remote identity provider, or null if none found
	 */
	Saml2RelyingPartyRegistration findByAlias(String alias);

}

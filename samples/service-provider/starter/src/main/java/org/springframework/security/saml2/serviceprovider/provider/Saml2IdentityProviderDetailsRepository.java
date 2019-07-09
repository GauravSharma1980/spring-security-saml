package org.springframework.security.saml2.serviceprovider.provider;

/**
 * Resolves a configured remote provider by entityId or alias
 */
public interface Saml2IdentityProviderDetailsRepository {

	/**
	 * Resolves an entity provider by entityId
	 * @param idpEntityId - unique entityId for the remote identity provider, not null
	 * @param localSpEntityId - entityId of the local application, not null
	 * @return a configured remote identity provider, or null if none found
	 */
	Saml2IdentityProviderDetails getIdentityProviderByEntityId(String idpEntityId, String localSpEntityId);

	/**
	 * Resolves an entity provider by entityId
	 * @param alias - unique alias, not null
	 * @return a configured remote identity provider, or null if none found
	 */
	Saml2IdentityProviderDetails getIdentityProviderByAlias(String alias, String localSpEntityId);

}
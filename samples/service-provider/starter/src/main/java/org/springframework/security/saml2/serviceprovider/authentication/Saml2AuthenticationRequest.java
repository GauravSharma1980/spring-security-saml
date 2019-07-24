/*
 * Copyright 2002-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.springframework.security.saml2.serviceprovider.authentication;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.saml2.credentials.Saml2X509Credential;

public class Saml2AuthenticationRequest {
	private final String localSpEntityId;
	private String webSsoUri;
	private final List<Saml2X509Credential> credentials;

	public Saml2AuthenticationRequest(String localSpEntityId,
									  String webSsoUri,
									  List<Saml2X509Credential> credentials) {
		this.localSpEntityId = localSpEntityId;
		this.webSsoUri = webSsoUri;
		this.credentials = credentials.stream()
			.filter(Saml2X509Credential::isSigningCredential)
			.collect(Collectors.toList());
	}


	public String getLocalSpEntityId() {
		return localSpEntityId;
	}

	public String getWebSsoUri() {
		return webSsoUri;
	}

	public List<Saml2X509Credential> getCredentials() {
		return credentials;
	}
}
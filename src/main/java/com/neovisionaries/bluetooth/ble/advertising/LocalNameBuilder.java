/*
* Copyright (c) 2020 - 2022 IoT Invent GmbH
* All rights reserved.
*/
package com.neovisionaries.bluetooth.ble.advertising;

/**
 * Builder for {@link LocalName} instances.
 *
 * @since 1.3
 */
class LocalNameBuilder implements ADStructureBuilder {
	public ADStructure build(final int length, final int type, final byte[] data) {
		return new LocalName(length, type, data);
	}
}

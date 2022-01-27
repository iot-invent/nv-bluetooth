/*
* Copyright (c) 2020 - 2022 IoT Invent GmbH
* All rights reserved.
*/
package com.neovisionaries.bluetooth.ble.advertising;

/**
 * Builder for {@link ServiceData} instances.
 *
 * @since 1.5
 */
class ServiceDataBuilder implements ADStructureBuilder {
	public ADStructure build(final int length, final int type, final byte[] data) {
		return new ServiceData(length, type, data);
	}
}

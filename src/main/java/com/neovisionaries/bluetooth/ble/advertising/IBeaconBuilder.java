/*
* Copyright (c) 2020 - 2022 IoT Invent GmbH
* All rights reserved.
*/
package com.neovisionaries.bluetooth.ble.advertising;

/**
 * Builder for {@link IBeacon}.
 */
class IBeaconBuilder implements ADManufacturerSpecificBuilder {
	public ADManufacturerSpecific build(final int length, final int type, final byte[] data, final int companyId) {
		return IBeacon.create(length, type, data, companyId);
	}
}

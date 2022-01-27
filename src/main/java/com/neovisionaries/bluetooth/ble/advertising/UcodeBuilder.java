/*
* Copyright (c) 2020 - 2022 IoT Invent GmbH
* All rights reserved.
*/
package com.neovisionaries.bluetooth.ble.advertising;

/**
 * Builder for {@link Ucode}.
 *
 * @since 1.1
 */
class UcodeBuilder implements ADManufacturerSpecificBuilder {
	public ADManufacturerSpecific build(final int length, final int type, final byte[] data, final int companyId) {
		return Ucode.create(length, type, data, companyId);
	}
}

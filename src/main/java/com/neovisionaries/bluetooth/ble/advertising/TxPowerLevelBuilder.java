/*
* Copyright (c) 2020 - 2022 IoT Invent GmbH
* All rights reserved.
*/
package com.neovisionaries.bluetooth.ble.advertising;

class TxPowerLevelBuilder implements ADStructureBuilder {
	public ADStructure build(final int length, final int type, final byte[] data) {
		return new TxPowerLevel(length, type, data);
	}
}

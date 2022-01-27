/*
* Copyright (c) 2020 - 2022 IoT Invent GmbH
* All rights reserved.
*/
package com.neovisionaries.bluetooth.ble.advertising;

import java.util.UUID;

import com.neovisionaries.bluetooth.ble.util.UUIDCreator;

/**
 * Builder for {@link UUIDs} instances.
 *
 * @since 1.1
 */
class UUIDsBuilder implements ADStructureBuilder {
	public ADStructure build(final int length, final int type, final byte[] data) {
		UUID[] uuids;

		switch (type) {
		// 16-bit UUIDs
		case 0x02: // Incomplete List of 16-bit Service Class UUIDs
		case 0x03: // Complete List of 16-bit Service Class UUIDs
		case 0x14: // List of 16-bit Service Solicitation UUIDs
			uuids = extract16(data);
			break;

		// 32-bit UUIDs
		case 0x04: // Incomplete List of 32-bit Service Class UUIDs
		case 0x05: // Complete List of 32-bit Service Class UUIDs
		case 0x1F: // List of 32-bit Service Solicitation UUIDs
			uuids = extract32(data);
			break;

		// 128-bit UUIDs
		case 0x06: // Incomplete List of 128-bit Service Class UUIDs
		case 0x07: // Complete List of 128-bit Service Class UUIDs
		case 0x15: // List of 128-bit Service Solicitation UUIDs
			uuids = extract128(data);
			break;

		default:
			return null;
		}

		return new UUIDs(length, type, data, uuids);
	}

	private UUID[] extract16(final byte[] data) {
		if (data == null) {
			return null;
		}

		final int count = data.length / 2;

		final UUID[] uuids = new UUID[count];

		for (int i = 0; i < count; ++i) {
			uuids[i] = UUIDCreator.from16(data, i * 2);
		}

		return uuids;
	}

	private UUID[] extract32(final byte[] data) {
		if (data == null) {
			return null;
		}

		final int count = data.length / 4;

		final UUID[] uuids = new UUID[count];

		for (int i = 0; i < count; ++i) {
			uuids[i] = UUIDCreator.from32(data, i * 4);
		}

		return uuids;
	}

	private UUID[] extract128(final byte[] data) {
		if (data == null) {
			return null;
		}

		final int count = data.length / 16;

		final UUID[] uuids = new UUID[count];

		for (int i = 0; i < count; ++i) {
			uuids[i] = UUIDCreator.from128(data, i * 16);
		}

		return uuids;
	}
}

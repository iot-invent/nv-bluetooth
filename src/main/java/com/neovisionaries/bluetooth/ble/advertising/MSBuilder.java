/*
* Copyright (c) 2020 - 2022 IoT Invent GmbH
* All rights reserved.
*/
package com.neovisionaries.bluetooth.ble.advertising;

import java.util.ArrayList;
import java.util.List;

/**
 * The base class for {@link ADManufacturerSpecificBuilder} implementations.
 */
public class MSBuilder implements ADManufacturerSpecificBuilder {
	private final List<ADManufacturerSpecificBuilder> mBuilders = new ArrayList<ADManufacturerSpecificBuilder>();

	public MSBuilder() {
	}

	public MSBuilder(final ADManufacturerSpecificBuilder... builders) {
		for (final ADManufacturerSpecificBuilder builder : builders) {
			mBuilders.add(builder);
		}
	}

	public ADManufacturerSpecific build(final int length, final int type, final byte[] data, final int companyId) {
		// For each builder.
		for (final ADManufacturerSpecificBuilder builder : mBuilders) {
			// Let the builder build an AD structure.
			final ADManufacturerSpecific structure = builder.build(length, type, data, companyId);

			// If the builder succeeded in building an AD structure.
			if (structure != null) {
				return structure;
			}
		}

		// None of the builders succeeded in building an AD structure.
		return null;
	}

	public void addBuilder(final ADManufacturerSpecificBuilder builder) {
		if (builder == null) {
			return;
		}

		mBuilders.add(builder);
	}

	public void removeBuilder(final ADManufacturerSpecificBuilder builder) {
		if (builder == null) {
			return;
		}

		mBuilders.remove(builder);
	}
}

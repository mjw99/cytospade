/**
* LnScale.java
*
*
* Cytobank (TM) is server and client software for web-based management, analysis,
* and sharing of flow cytometry data.
*
* Copyright (C) 2009 Cytobank, Inc. All rights reserved.
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU Affero General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU Affero General Public License for more details.
*
* You should have received a copy of the GNU Affero General Public License
* along with this program. If not, see <http://www.gnu.org/licenses/>.
*
* Cytobank, Inc.
* 659 Oak Grove Avenue #205
* Menlo Park, CA 94025
*
* http://www.cytobank.org
*/
package name.mjw.facs.scale;

/**
* <p>
* A ln (natural logarithm) scale.
* </p>
*
* <p>
* The logarithm is base e (Euler's constant).
* </p>
*/
public final class LnScale implements Scale {
    /**
* <p>
* A blank constructor for <code>LnScale</code>.
* </p>
*/
    LnScale() {
    }

    /**
* <p>
* Returns the transformed value of x.
* </p>
*
* @param x
* double value of x.
* @return double transformed value of x.
*/
    public double getValue(double x) {
        return Math.log(x);
    }

    /**
* <p>
* Returns the transformed value of x.
* </p>
*
* <p>
* The scale ignores the optional scale argument and simply calls the other
* version of the getValue method.
* </p>
*
* @param x
* double value of x.
* @param arg
* <code>ScaleArgument</code> object to the optional scale
* argument.
* @return double transformed value of x.
*/
    public double getValue(double x, ScaleArgument arg) {
        return getValue(x);
    }

    /**
* <p>
* Returns the un-transformed value of a given bin, in terms of real scale
* values, given the number of bins and the region of the scale these bins
* represent.
* </p>
*
* @param binIndex
* <code>int</code> the index of the bin to un-transform.
* @param numBins
* <code>int</code> the total number of bins.
* @param scaleMin
* <code>double</code> value of the minimum scale value.
* @param scaleMax
* <code>double</code> value of the maximum scale value.
* @param arg
* <code>ScaleArgument</code> object to the optional scale
* argument.
*
* @return double un-transformed value of x.
*/
    public double unbin(int binIndex, int numBins, double scaleMin, double scaleMax, ScaleArgument arg) {
        double unbinnedValue = 0.0d;

        /*
* The range of data will be linear from log10(scaleMin) to
* log10(scaleMax) So 1 = log(scaleMin) and numBins = log(scaleMax)
*/

        // Calculate the linear fraction of the scale the bin represents
        double fractionOfScale = (double) binIndex / (double) numBins;

        // Calculate the total linear range of the scale
        double scaleRange = (Math.log(scaleMax)) - (Math.log(scaleMin));

        // Calculate the exponent the bin represents
        double valueExponent = (Math.log(scaleMin)) + (fractionOfScale * scaleRange);

        // Calculate the unbinned value
        unbinnedValue = Math.exp(valueExponent);

        return unbinnedValue;
    }

    /**
* Return a unique identifier for this class
* @return A String representation of this class for caching
*/

    public String cacheKey() {
        return "LnScale";
    }
}


/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.fileupload2;

import javax.servlet.http.HttpServletRequest;

final class HttpServletRequestFactory {

    public static HttpServletRequest createHttpServletRequestWithNullContentType() {
        final byte[] requestData = "foobar".getBytes();
        return new MockHttpServletRequest(
                            requestData,
                            null);
    }

    static public HttpServletRequest createInvalidHttpServletRequest() {
        final byte[] requestData = "foobar".getBytes();
        return new MockHttpServletRequest(
                            requestData,
                            AbstractFileUpload.MULTIPART_FORM_DATA);
    }

    public static HttpServletRequest createValidHttpServletRequest(
            final String[] strFileNames) {
        // todo - provide a real implementation

        final StringBuilder sbRequestData = new StringBuilder();

        for (final String strFileName : strFileNames) {
            sbRequestData.append(strFileName);
        }

        final byte[] requestData = sbRequestData.toString().getBytes();

        return new MockHttpServletRequest(
                            requestData,
                            AbstractFileUpload.MULTIPART_FORM_DATA);
    }

}

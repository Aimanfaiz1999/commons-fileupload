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

import java.io.IOException;
import java.util.List;

import javax.naming.SizeLimitExceededException;

import org.apache.commons.fileupload2.pub.FileUploadByteCountLimitException;

/**
 * An iterator, as returned by
 * {@link AbstractFileUpload#getItemIterator(RequestContext)}.
 */
public interface FileItemIterator {

    List<FileItem> getFileItems() throws IOException;

    /**
     * Gets the maximum size of a single file. An {@link FileUploadByteCountLimitException}
     * will be thrown, if there is an uploaded file, which is exceeding this value.
     * By default, this value will be copied from the {@link AbstractFileUpload#getFileSizeMax()
     * FileUploadBase} object, however, the user may replace the default value with a
     * request specific value by invoking {@link #setFileSizeMax(long)} on this object.
     * @return The maximum size of a single, uploaded file. The value -1 indicates "unlimited".
     */
    long getFileSizeMax();

    /**
     * Gets the maximum size of the complete HTTP request. A {@link SizeLimitExceededException}
     * will be thrown, if the HTTP request will exceed this value.
     * By default, this value will be copied from the {@link AbstractFileUpload#getSizeMax()
     * FileUploadBase} object, however, the user may replace the default value with a
     * request specific value by invoking {@link #setSizeMax(long)} on this object.
     * @return The maximum size of the complete HTTP request. The value -1 indicates "unlimited".
     */
    long getSizeMax();

    /**
     * Tests whether another instance of {@link FileItemStream}
     * is available.
     *
     * @throws FileUploadException Parsing or processing the
     *   file item failed.
     * @throws IOException Reading the file item failed.
     * @return True, if one or more additional file items
     *   are available, otherwise false.
     */
    boolean hasNext() throws IOException;

    /**
     * Returns the next available {@link FileItemStream}.
     *
     * @throws java.util.NoSuchElementException No more items are available. Use
     * {@link #hasNext()} to prevent this exception.
     * @throws FileUploadException Parsing or processing the
     *   file item failed.
     * @throws IOException Reading the file item failed.
     * @return FileItemStream instance, which provides
     *   access to the next file item.
     */
    FileItemStream next() throws IOException;

    /**
     * Sets the maximum size of a single file. An {@link FileUploadByteCountLimitException}
     * will be thrown, if there is an uploaded file, which is exceeding this value.
     * By default, this value will be copied from the {@link AbstractFileUpload#getFileSizeMax()
     * FileUploadBase} object, however, the user may replace the default value with a
     * request specific value by invoking {@link #setFileSizeMax(long)} on this object, so
     * there is no need to configure it here.
     * <p>
     * <em>Note:</em> Changing this value doesn't affect files, that have already been uploaded.
     * </p>
     * @param fileSizeMax The maximum size of a single, uploaded file. The value -1 indicates "unlimited".
     */
    void setFileSizeMax(long fileSizeMax);

    /**
     * Sets the maximum size of the complete HTTP request. A {@link SizeLimitExceededException}
     * will be thrown, if the HTTP request will exceed this value.
     * By default, this value will be copied from the {@link AbstractFileUpload#getSizeMax()
     * FileUploadBase} object, however, the user may replace the default value with a
     * request specific value by invoking {@link #setSizeMax(long)} on this object.
     * <p>
     * <em>Note:</em> Setting the maximum size on this object will work only, if the iterator is not
     * yet initialized. In other words: If the methods {@link #hasNext()}, {@link #next()} have not
     * yet been invoked.
     * </p>
     * @param sizeMax The maximum size of the complete HTTP request. The value -1 indicates "unlimited".
     */
    void setSizeMax(long sizeMax);
}

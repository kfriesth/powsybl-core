/**
 * Copyright (c) 2017, RTE (http://www.rte-france.com)
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package eu.itesla_project.afs.mapdb;

import com.google.common.jimfs.Configuration;
import com.google.common.jimfs.Jimfs;
import eu.itesla_project.afs.core.AppFileSystem;
import eu.itesla_project.afs.mapdb.storage.MapDbAppFileSystemStorage;
import eu.itesla_project.computation.ComputationManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Geoffroy Jamgotchian <geoffroy.jamgotchian at rte-france.com>
 */
public class MapDbAppFileSystemProviderTest {

    private FileSystem fileSystem;

    private Path dbFile;

    @Before
    public void setUp() throws Exception {
        fileSystem = Jimfs.newFileSystem(Configuration.unix());
        dbFile = fileSystem.getPath("/db");
        Files.createFile(dbFile);
    }

    @After
    public void tearDown() throws Exception {
        fileSystem.close();
    }

    @Test
    public void test() {
        ComputationManager computationManager = Mockito.mock(ComputationManager.class);
        MapDbAppFileSystemConfig config = new MapDbAppFileSystemConfig("drive", dbFile);
        List<AppFileSystem> fileSystems = new MapDbAppFileSystemProvider(Collections.singletonList(config),
                                                                         (name, file) -> MapDbAppFileSystemStorage.createHeap(name))
                .getFileSystems(computationManager);
        assertEquals(1, fileSystems.size());
        assertTrue(fileSystems.get(0) instanceof MapDbAppFileSystem);
        assertEquals("drive", fileSystems.get(0).getName());
    }
}
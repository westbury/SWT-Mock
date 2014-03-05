package com.github.swtmock.mock;

import java.util.HashSet;
import java.util.Set;

import com.github.swtmock.api.IDisplay;

public class MockDisplay implements IDisplay {

	Set<MockShell> shells = new HashSet<MockShell>();

}

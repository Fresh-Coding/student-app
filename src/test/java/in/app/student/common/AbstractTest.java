package in.app.student.common;

import java.util.HashSet;
import java.util.Set;

import org.easymock.EasyMock;

/**
 * Abstract unit test base class.
 * 
 */
public abstract class AbstractTest {

	private Set<Object> mocks = new HashSet<Object>();

	/**
	 * Returns the pre-configured mock objects for this test case.
	 * 
	 * @return the mocks
	 */
	public Set<Object> getMocks() {
		return mocks;
	}

	/**
	 * Sets the pre-configured mock objects for this test case.
	 * 
	 * @param mocks
	 *            the mocks to set
	 */
	public void setMocks(Set<Object> mocks) {
		this.mocks = mocks;
	}

	/**
	 * Sets the pre-configured mock objects for this test case.
	 * 
	 * @param mocks
	 *            the mocks to set
	 */
	public void setMocks(Object... mocks) {
		final Set<Object> allMocks = new HashSet<Object>(mocks.length);
		for (Object mock : mocks) {
			allMocks.add(mock);
		}
		setMocks(allMocks);
	}

	/**
	 * Replays the pre-configured mocks, as well as the additionally specified mocks.
	 * 
	 * @param mocks
	 *            the additionally specified mocks to replay
	 * @see EasyMock#replay(Object...)
	 */
	public void replay(Object... mocks) {
		EasyMock.replay(allMocks(mocks));
	}

	/**
	 * Verifies the pre-configured mocks, as well as the additionally specified mocks.
	 * 
	 * @param mocks
	 *            the additionally specified mocks to verify
	 * @see EasyMock#verify(Object...)
	 */
	public void verify(Object... mocks) {
		EasyMock.verify(allMocks(mocks));
	}

	/**
	 * Resets the pre-configured mocks, as well as the additionally specified mocks.
	 * 
	 * @param mocks
	 *            the additionally specified mocks to reset
	 * @see EasyMock#reset(Object...)
	 */
	public void reset(Object... mocks) {
		EasyMock.reset(allMocks(mocks));
	}

	/**
	 * Joins <code>mocks</code> into the set of pre-configured mocks, and returns the resulting set.
	 * 
	 * @param mocks
	 *            the mocks to join
	 * @return the resulting set
	 */
	private Object[] allMocks(Object... mocks) {
		final Set<Object> allMocks = new HashSet<Object>(getMocks());
		for (Object mock : mocks) {
			allMocks.add(mock);
		}
		return allMocks.toArray();
	}

}

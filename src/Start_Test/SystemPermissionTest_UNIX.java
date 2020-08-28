package Start_Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Start.SystemAdmin;
import Start.SystemPermission;
import Start.SystemProfile;
import Start.SystemUser;

public class SystemPermissionTest_UNIX {
	
	private SystemPermission permission;
	private SystemUser user;
	private SystemProfile profile;
	private SystemAdmin admin;

	@Before
	public void setUp() throws Exception {
		user = new SystemUser();
		profile = new SystemProfile(true); // ��Ҫ UNIX Ȩ��
		admin = new SystemAdmin();
		permission = new SystemPermission(user, profile);
	}

	@Test
	public void testClaimedBy() {
		// ֱ�� Claim ����
		// �����CLAIMED ״̬�� isGranted = false
		permission.claimedBy(admin);
		assertEquals("claimed", permission.CLAIMED, permission.state());
		assertEquals("claimed", false, permission.isGranted());

		// �� Claim �ٽ��� Grant ������
		// �����UNIX_REQUESTED ״̬�� isGranted = false
		permission.grantedBy(admin);
		assertEquals("granted", permission.UNIX_REQUESTED, permission.state());
		assertEquals("granted", false, permission.isGranted());

		// �ٽ��� Claim ����
		// �����UNIX_CLAIMED ״̬�� isGranted = false
		permission.claimedBy(admin);
		assertEquals("granted", permission.UNIX_CLAIMED, permission.state());
		assertEquals("granted", false, permission.isGranted());
	}

	@Test
	public void testDeniedBy() {
		// δ Claim ��״̬���� Denied ������
		// �����REQUESTED ״̬�� isGranted = false
		permission.grantedBy(admin);
		assertEquals("requested", permission.REQUESTED, permission.state());
		assertEquals("not granted", false, permission.isGranted());

		// �� Claim �ٽ��� Grant ���������� UNIX_REQUESTED ״̬
		// ���� Claim �ٽ��� Denied ����
		// �����DENIED ״̬�� isGranted = false
		permission.claimedBy(admin);
		permission.grantedBy(admin);
		permission.claimedBy(admin);
		permission.deniedBy(admin);
		assertEquals("granted", permission.DENIED, permission.state());
		assertEquals("granted", false, permission.isGranted());
	}

	@Test
	public void testGrantedBy() {
		// δ Claim ��״̬���� Grant ������
		// �����REQUESTED ״̬�� isGranted = false
		permission.grantedBy(admin);
		assertEquals("requested", permission.REQUESTED, permission.state());
		assertEquals("not granted", false, permission.isGranted());

		// �� Claim �ٽ��� Grant ���������� UNIX_REQUESTED ״̬
		// ���� Claim �ٽ��� Grant ����
		// �����GRANTED ״̬�� isGranted = true
		permission.claimedBy(admin);
		permission.grantedBy(admin);
		permission.claimedBy(admin);
		permission.grantedBy(admin);
		assertEquals("granted", permission.GRANTED, permission.state());
		assertEquals("granted", true, permission.isGranted());
	}
}
package Finish;

public class PermissionUnixRequested extends PermissionState {

	protected PermissionUnixRequested() {
		super("UNIX_REQUESTED");
		// TODO Auto-generated constructor stub
	}

	public void claimedBy(SystemAdmin admin, SystemPermission permission) {

		permission.willBeHandledBy(admin);
		
		permission.setState(PermissionState.UNIX_CLAIMED);
	}
}

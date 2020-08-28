package Finish;

public class PermissionRequested extends PermissionState {

	protected PermissionRequested() {
		super("REQUESTED");
		// TODO Auto-generated constructor stub
	}
	
	public void claimedBy(SystemAdmin admin, SystemPermission permission) {

		permission.willBeHandledBy(admin);
		
		permission.setState(PermissionState.CLAIMED);
	}
}

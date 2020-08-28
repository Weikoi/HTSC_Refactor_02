package Finish;

public abstract class PermissionState {
	private String name;

	protected PermissionState(String name) {
		this.name = name;
	}

	public final static PermissionState REQUESTED = new PermissionRequested();
	public final static PermissionState CLAIMED = new PermissionClaimed();
	public final static PermissionState GRANTED = new PermissionGranted();
	public final static PermissionState DENIED = new PermissionDenied();
	public final static PermissionState UNIX_REQUESTED = new PermissionUnixRequested();
	public final static PermissionState UNIX_CLAIMED = new PermissionUnixClaimed();

	public String toString() {
		return name;
	}
	
	public void claimedBy(SystemAdmin admin, SystemPermission permission) {
		
	}
	
	public void deniedBy(SystemAdmin admin, SystemPermission permission) {
		
	}
	
	public void grantedBy(SystemAdmin admin, SystemPermission permission) {
		
	}
}

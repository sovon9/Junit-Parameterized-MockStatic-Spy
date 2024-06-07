package junitParameterized.mockStatic;

public class CreateUser
{
	public User createUser(User user)
	{
		int generate = IDGenerator.generate();
		user.setId(generate);
		return user;
	}
}

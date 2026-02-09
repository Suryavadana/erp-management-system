# Database Design – ERP Management System

## Purpose
This database is designed to support an ERP management system that handles users, employees, projects, and tasks.  
It supports role-based access and real-world business workflows.

---

## Tables Overview

### users
Stores authentication and login-related information for all users of the system.

Key responsibility:
- Login credentials
- Account status

---

### roles
Defines different roles available in the system.

Examples:
- ADMIN
- MANAGER
- EMPLOYEE

---

### user_roles
Acts as a mapping table between users and roles.

Reason:
- One user can have multiple roles
- Roles can be reused for many users

---

### employees
Stores employee-specific information linked to a user account.

Reason:
- Separates authentication data from employee profile data
- Allows future HR-related expansion

---

### projects
Stores project details handled by the organization.

Includes:
- Project name
- Description
- Timeline
- Status

---

### project_members
Maps employees to projects.

Reason:
- One project can have multiple employees
- One employee can work on multiple projects

---

### tasks
Stores tasks assigned within a project.

Includes:
- Task title
- Status
- Priority
- Assigned employee

---

## Relationships

- One user is associated with one employee profile
- One user can have multiple roles
- One project can have multiple employees
- One project can have multiple tasks
- One employee can be assigned multiple tasks

---

## Design Decisions

- Authentication data is separated from employee data for better security.
- Many-to-many relationships are used where flexibility is required.
- Tasks are linked to projects to maintain proper work tracking.
- Foreign keys are used to maintain data integrity.

---

## Future Improvements

- Add audit fields (created_by, updated_by)
- Use ENUMs for task status and priority
- Add time tracking and leave management tables
- Optimize queries using indexes
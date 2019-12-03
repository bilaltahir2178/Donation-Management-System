CREATE DATABASE [Donation];

--USE Master
--DROP DATABASE [Donation];

USE [Donation];

CREATE TABLE [Project] (
	[ID] INT,
	[Name] VARCHAR(MAX),
	[Description] VARCHAR(MAX),
	[ManagerID] INT,
	[Budget] INT,
	[TeamID] INT
);

CREATE TABLE [Person] (
	[ID] INT,
	[Name] VARCHAR(MAX),
	[CNIC] VARCHAR(MAX),
	[Address] VARCHAR(MAX),
	[Phone] VARCHAR(MAX),
	[DateOfBirth] DATE
);

CREATE TABLE [Donor] (
	[PersonID] INT,
	[DonationID] INT,
	[PledgeID] INT
);

CREATE TABLE [Donation] (
	[ID] INT,
	[DonorID] VARCHAR(MAX),
	[FundID] VARCHAR(MAX),
	[SubjectID] INT,
	[Description] VARCHAR(MAX)
);

CREATE TABLE [Fund] (
	[ID] INT,
	[Name] VARCHAR(MAX),
	[ProjectID] INT,
	[DonationID] INT
);

CREATE TABLE [Team] (
	[ID] INT,
	[PersonID] INT,
	[TeamLeadFlag] INT
);

CREATE TABLE [Subject] (
	[PersonID] INT,
	[Income] INT
);

CREATE TABLE [Pledge] (
	[ID] INT,
	[Description] VARCHAR(MAX)
);

CREATE TABLE [Applicant] (
	[PersonID] INT,
	[Income] INT
);

--DROP TABLE [Project];
--DROP TABLE [Person];
--DROP TABLE [Donor];
--DROP TABLE [Donation];
--DROP TABLE [Fund];
--DROP TABLE [Team];
--DROP TABLE [Subject];
--DROP TABLE [Pledge];
--DROP TABLE [Applicant];

SELECT * FROM [Project];
SELECT * FROM [Person];
SELECT * FROM [Donor];
SELECT * FROM [Donation];
SELECT * FROM [Fund];
SELECT * FROM [Team];
SELECT * FROM [Subject];
SELECT * FROM [Pledge];
SELECT * FROM [Applicant];
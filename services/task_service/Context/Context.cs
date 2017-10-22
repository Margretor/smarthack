using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Data;
using System.Data.Entity;
using System.Data.Entity.ModelConfiguration.Conventions;
using Tasks.Models;

namespace Tasks.Context
{
    public class DatabaseContext : DbContext
    {

        public DatabaseContext() : base("Smarthack")
        {
        }

        public DbSet<Task> Tasks { get; set; }
        public DbSet<Comment> Comments {get;set;}
        public DbSet<Project> Projects { get; set; }
        public DbSet<Log> Logs { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Conventions.Remove<PluralizingTableNameConvention>();
        }
    }
}
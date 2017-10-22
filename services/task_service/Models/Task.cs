using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace Tasks.Models
{
    public enum Status { Open, InProgress, ReadyForTesting, Done }
    public enum Type { Bug, Task }
    public enum Priority { Hight, Medium, Low }

    public class Task
    {
        [Key]
        public int Id { get; set; }

        public DateTime Start { get; set; }
        public DateTime Deadline { get; set; }

        public Status Status { get; set; }
        public Type Type { get; set; }
        public Priority Priority { get; set; }
        public int Project { get; set; }

        public string Title { get; set; }
        public string Reporter { get; set; }
        public string Owner { get; set; }
        public string Description { get; set; }
        
        public TimeSpan Estimation { get; set; }
    }
}
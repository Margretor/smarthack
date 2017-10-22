using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Tasks.DTO
{
    public class TaskDTO
    {
        public int Id { get; set; }

        public DateTime Start { get; set; }
        public DateTime Deadline { get; set; }

        public string Status { get; set; }
        public string Type { get; set; }
        public string Priority { get; set; }
        public ProjectDTO Project { get; set; }

        public string Title { get; set; }
        public string Reporter { get; set; }
        public string Owner { get; set; }
        public string Description { get; set; }

        public TimeSpan Estimation { get; set; }
        public TimeSpan Logged { get; set; }

        public IList<CommentDTO> Comments { get; set; }
        public IList<LogDTO> Logs { get; set; }

    }
}